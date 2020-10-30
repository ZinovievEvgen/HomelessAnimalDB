import express from 'express';
import glob from 'glob';

import Template500 from '@assets/static/500.tpl';
import { DEFAULT_SERVER_PORT } from '@constants';
import dirs from '@root/../dirs';

import { ISSRFunc, ITemplateProps } from '@types';
import Templator from '@utils/Templator';
import { StaticRouterContext } from 'react-router';

const PORT = process.env.FRONT_PORT || DEFAULT_SERVER_PORT;
const expressApp = express();

glob.sync(`.${dirs.entry}/*`).forEach((path: string) => {
  const name: string = path.match(/\/([^/]*)$/)[1];
  const nameLower: string = name.toLowerCase();

  if (nameLower === 'static') {
    return;
  }

  expressApp.get(`/${nameLower}/*`, (req, res) => {
    const location: string = req.url;
    const context: StaticRouterContext = {};

    let outputString: string = Template500;

    try {
      const {
        default: renderFunc,
      }: {
        default: ISSRFunc;
      } = require(`${path.replace('./src', '.')}/server.tsx`);

      const { template, ...otherProps }: ITemplateProps = renderFunc({
        location,
        context,
        entry: nameLower,
      });

      outputString = Templator(template, {
        CLIENT_SCRIPT_SRC: `/static/${nameLower}/index.js`,
        CLIENT_STYLE_SRC: `/static/${nameLower}/index.css`,
        ...otherProps,
      });
    } catch (error) {
      // tslint:disable-next-line
      console.error(error);
      res.sendStatus(500).send(outputString);
    }

    res.send(outputString);
  });
});

expressApp.use(express.static('./dist'));

expressApp.listen(PORT, () => {
  // tslint:disable-next-line
  console.log(`Server is listening on port ${PORT}`);
});
