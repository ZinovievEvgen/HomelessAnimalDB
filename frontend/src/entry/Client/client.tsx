import React from 'react';
import ReactDOM from 'react-dom';

import ClientContainer from '@containers/ClientContainer';
import Client from '@root/apps/Client';

import { ROOT_ELEMENT_NAME } from '@constants';

const App: React.FunctionComponent = () => (
  <ClientContainer>
    <Client />
  </ClientContainer>
);

ReactDOM.hydrate(<App />, document.getElementById(ROOT_ELEMENT_NAME));
