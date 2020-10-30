import React from 'react';
import { Route, Switch } from 'react-router-dom';

import withClientContext from '@containers/SSRContext/ClientContext';

import ServerContext from '@containers/SSRContext/ServerContext';
import * as T from './Switch.types';

const MySwitch: React.FunctionComponent<T.ISwitchContext> = ({
  routes,
  entry = ServerContext.entry,
}) => {
  return (
    <Switch>
      {routes.map(
        (
          { path, Component, ...otherProps }: T.IRoute,
          index: number
        ): React.ReactNode => {
          const newPath: string = path
            ? `/${entry}/${path}`.replace('//', '/')
            : null;

          return (
            <Route
              key={index}
              path={newPath}
              component={Component}
              {...otherProps}
            />
          );
        }
      )}
    </Switch>
  );
};

export const SwitchWithContext = withClientContext<T.ISwitchProps>(MySwitch);
