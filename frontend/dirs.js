const path = require('path');

module.exports = {
  root: path.resolve(__dirname, './src'),
  dist: path.join(__dirname, './dist'),
  include: /node_modules\/((grommet|grommet-icons)\/).*/,

  entry: path.resolve(__dirname, './src/entry'),

  components: path.resolve(__dirname, './src/components'),
  containers: path.resolve(__dirname, './src/containers'),
  hooks: path.resolve(__dirname, './src/hooks'),
  utils: path.resolve(__dirname, './src/utils'),
  assets: path.resolve(__dirname, './src/assets'),
  pages: path.resolve(__dirname, './src/pages'),
  apps: path.resolve(__dirname, './src/apps'),
  types: path.resolve(__dirname, './src/types.ts'),
  constants: path.resolve(__dirname, './src/constants.ts'),
};
