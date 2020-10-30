import React from 'react';
import { StaticRouter as Router } from 'react-router-dom';

import * as T from './ServerContainer.types';

export const ServerContainer: React.FunctionComponent<T.IServerContainerProps> = ({
  children,
  location,
  context,
  entry,
}) => (
  <Router location={location} context={context}>
    {children}
  </Router>
);
