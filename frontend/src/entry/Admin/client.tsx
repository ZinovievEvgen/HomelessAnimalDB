import React from 'react';
import ReactDOM from 'react-dom';

import { ROOT_ELEMENT_NAME } from '@constants';
import ClientContainer from '@containers/ClientContainer';
import Admin from '@root/apps/Admin';

import ready from '@utils/DOMReady';

ready.then(() => {
  const App: React.FunctionComponent = () => (
    <ClientContainer>
      <Admin />
    </ClientContainer>
  );

  ReactDOM.hydrate(<App />, document.getElementById(ROOT_ELEMENT_NAME));
});
