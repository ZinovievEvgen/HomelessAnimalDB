import * as React from 'react';

import * as T from '../SSRContext.types';

export const ClientContext = React.createContext<T.IClientContext>(
  {} as T.IClientContext
);

export const withClientContext = <I extends {}>(
  Component: React.FunctionComponent<I & T.IClientContext>
): React.FunctionComponent<I> => (props: any) => (
  <ClientContext.Consumer>
    {(context: T.IClientContext) => <Component {...props} {...context} />}
  </ClientContext.Consumer>
);
