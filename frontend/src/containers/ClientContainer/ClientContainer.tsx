import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import ClientContextProvider from '@containers/SSRContext/ClientContext/ClientContextProvider';

import * as T from './ClientContainer.types';

export const ClientContainer: React.FunctionComponent<T.IClientContainerProps> = ({
  children,
}) => (
  <ClientContextProvider>
    <Router>{children}</Router>
  </ClientContextProvider>
);
