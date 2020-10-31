const path = require('path');

const { DefinePlugin } = require('webpack');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
// const HtmlWebpackPlugin = require('html-webpack-plugin');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
const { TypedCssModulesPlugin } = require('typed-css-modules-webpack-plugin');

const glob = require('glob');

const dirs = require('./dirs.js');
const includeDirs = [dirs.root, dirs.include];

module.exports = (env, argv) => {
  const isDevMode = argv.mode === 'development';

  return {
    resolve: {
      alias: {
        '@components': dirs.components,
        '@containers': dirs.containers,
        '@pages': dirs.pages,
        '@apps': dirs.apps,
        '@hooks': dirs.hooks,
        '@utils': dirs.utils,
        '@assets': dirs.assets,
        '@entry': dirs.entry,
        '@types': dirs.types,
        '@constants': dirs.constants,
        '@root': dirs.root,
      },
      extensions: ['.ts', '.tsx', '.js', '.json'],
    },
    entry: {
      server: `${dirs.root}/index.ts`,
      ...glob.sync(`${dirs.entry}/*/client.tsx`).reduce((acc, path) => {
        const name = path.match(/\/([^/]*)\/client.tsx?$/)[1].toLowerCase();
        const outputFileName = `static/${name}/index`;
        acc[outputFileName] = path;
        return acc;
      }, {}),
    },
    output: {
      path: dirs.dist,
      filename: '[name].js' + (isDevMode ? '' : '?[hash]'),
      /* publicPath: dirs.dist,
      libraryTarget: 'umd',
      globalObject: 'this', */
    },
    target: 'node',
    devtool: isDevMode && 'source-map',
    module: {
      rules: [
        {
          test: /\.(j|ts)x?$/,
          include: includeDirs,
          loader: 'ts-loader',
          options: {
            transpileOnly: true,
          },
        },
        {
          enforce: 'pre',
          test: /\.js$/,
          loader: 'source-map-loader',
        },
        {
          test: /\.css?$/,
          include: includeDirs,
          use: [
            {
              loader: MiniCssExtractPlugin.loader,
            },
            {
              loader: 'css-loader',
              options: {
                modules: {
                  localIdentName:
                    argv.mode === 'production'
                      ? '[hash:10]'
                      : '[name]__[local]_[hash:5]',
                },
                localsConvention: 'camelCase',
              },
            },
            {
              loader: 'postcss-loader',
              options: {
                config: {
                  /*
                    Используем локальный конфиг
                    Чтобы postcss не лез в конфиги @media-platform|@media-ui
                  */
                  path: path.resolve('./postcss.config.js'),
                },
              },
            },
          ],
        },
        {
          test: /\.svg/,
          loader: '@svgr/webpack',
        },
        {
          test: [/\.jpe?g$/, /\.png$/],
          use: [
            {
              loader: 'url-loader',
              options: {
                limit: false,
              },
            },
          ],
        },
        {
          test: /\.tpl/,
          loader: 'raw-loader',
        },
      ],
    },
    plugins: [
      /* new HtmlWebpackPlugin({
        template: 'src/assets/static/index.html',
      }), */
      new DefinePlugin({
        DEBUG: isDevMode,
      }),
      new MiniCssExtractPlugin({
        filename: '[name].css',
        chunkFilename: '[id].css',
      }),
      new OptimizeCssAssetsPlugin(),
      new TypedCssModulesPlugin({
        globPattern: 'src/**/*.css',
      }),
    ],
  };
};
