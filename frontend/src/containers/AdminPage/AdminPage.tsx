import React from 'react';

import PageHeader from '@components/PageHeader';

import DashboardSVG from '@assets/static/images/dashboard.svg';
import ListSVG from '@assets/static/images/list.svg';

import AdminContent from './AdminContent';
import AdminLeftMenu from './AdminLeftMenu';

import * as S from './AdminPage.css';
import * as T from './AdminPage.types';

export const AdminPage: React.FunctionComponent<T.IAdminPageProps> = ({
  children,
}) => {
  const deaAuth = (): void => {
    // tslint:disable-next-line
    console.log('deauth');
  };

  return (
    <div className={S.wrap}>
      <PageHeader
        className={S.header}
        icon={{
          url: '/',
          Component: <DashboardSVG />,
          text: 'Панель управления',
        }}
        hrefs={[
          {
            name: 'Выйти',
            onClick: deaAuth,
          },
        ]}
      />
      <div className={S.masterBlock}>
        <AdminLeftMenu
          links={[
            {
              url: '/',
              icon: <DashboardSVG />,
              name: 'Главная',
            },
            {
              url: '/list/',
              icon: <ListSVG />,
              name: 'Списки животных',
            },
          ]}
        />
        <AdminContent>{children}</AdminContent>
      </div>
    </div>
  );
};
