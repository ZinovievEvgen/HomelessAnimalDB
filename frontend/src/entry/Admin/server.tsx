import React from 'react';
import ReactDOMServer from 'react-dom/server';

import ServerContainer from '@containers/ServerContainer';
import ServerContext, {
  exportContext,
} from '@containers/SSRContext/ServerContext';
import Admin from '@root/apps/Admin';

import Template from '@assets/static/index.tpl';
import { ROOT_ELEMENT_NAME } from '@constants';
import { ISSRProps, ITemplateProps } from '@types';

const RenderFunc = ({
  location,
  context,
  entry,
}: ISSRProps): ITemplateProps => {
  Object.assign(ServerContext, { entry, context });

  const RenderedApp = ReactDOMServer.renderToString(
    <ServerContainer location={location} context={context} entry={entry}>
      <Admin />
    </ServerContainer>
  );

  const TemplateProps: ITemplateProps = {
    template: Template,
    TITLE: 'Pets - Admin dashboard',
    ROOT_ELEMENT_NAME,
    ROOT_INNER: RenderedApp,
    BODY_SLOT_BOTTOM: exportContext(),
  };

  return TemplateProps;
};

export default RenderFunc;
