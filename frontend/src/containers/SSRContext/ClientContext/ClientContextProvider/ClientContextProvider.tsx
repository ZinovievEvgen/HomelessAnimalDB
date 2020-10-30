import React from 'react';

import { ClientContext } from '../../ClientContext';

import { PRERENDERED_KEY } from '../../SSRContext.contants';
import * as T from './ClientContextProvider.types';

export const ClientContextProvider: React.FunctionComponent<T.IClientContextProviderProps> = ({
  children,
}) => {
  // @ts-ignore
  const prerenderedContext: string = window[PRERENDERED_KEY];
  const clientContext = JSON.parse(prerenderedContext);

  return (
    <ClientContext.Provider value={clientContext}>
      {children}
    </ClientContext.Provider>
  );
};
