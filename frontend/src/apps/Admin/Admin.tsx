import React from 'react';

import Switch from '@components/Switch';

import Auth from '@pages/Admin/Auth';
import Home from '@pages/Admin/Home';

export const Admin: React.FunctionComponent = () => (
  <Switch
    routes={[
      {
        path: '/auth',
        Component: Auth,
      },
      {
        Component: Home,
      },
    ]}
  />
);
