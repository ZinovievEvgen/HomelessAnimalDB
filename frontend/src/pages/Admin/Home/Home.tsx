import React from 'react';

import AdminPage from '@containers/AdminPage';

import * as T from './Home.types';

export const Home: React.FunctionComponent<T.IHomeProps> = ({
  location: { pathname },
}) => {
  return <AdminPage pathname={pathname}>Yes is is!</AdminPage>;
};
