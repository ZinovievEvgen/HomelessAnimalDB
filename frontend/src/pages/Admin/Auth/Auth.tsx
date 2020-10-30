import React from 'react';

import AdminPage from '@containers/AdminPage';

import * as T from './Auth.types';

export const Auth: React.FunctionComponent<T.IAuthProps> = ({}) => {
  return <AdminPage>Hey, lets auth plz!</AdminPage>;
};
