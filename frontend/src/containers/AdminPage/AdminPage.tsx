import React from 'react';

import PageHeader from '@components/PageHeader';

import AedSVG from '@assets/static/images/aed.svg';
import ClearSVG from '@assets/static/images/clear.svg';
import ListSVG from '@assets/static/images/list.svg';
import OrganizationSVG from '@assets/static/images/organization.svg';
import SansSVG from '@assets/static/images/sans.svg';
import SortSVG from '@assets/static/images/sort.svg';
import SubtractSVG from '@assets/static/images/subtract.svg';
import TagSVG from '@assets/static/images/tag.svg';
import UserFemaleSVG from '@assets/static/images/user-female.svg';

import AdminContent from './AdminContent';
import AdminLeftMenu from './AdminLeftMenu';

import * as S from './AdminPage.css';
import * as T from './AdminPage.types';

export const AdminPage: React.FunctionComponent<T.IAdminPageProps> = ({
  children,
  pathname,
}) => {
  const deaAuth = (): void => {
    // tslint:disable-next-line
    console.log('deauth');
  };

  return (
    <div className={S.wrap}>
      <PageHeader
        className={S.header}
        title={{
          url: '/',
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
          pathname={pathname}
          links={[
            {
              url: '/',
              icon: <ListSVG />,
              name: 'Списки животных',
            },
            {
              url: '/orphananges/',
              icon: <SortSVG />,
              name: 'Список приютов',
            },
            {
              url: '/explote_organizations/',
              icon: <OrganizationSVG />,
              name: 'Эксплуатационные организации',
            },
            {
              url: '/animal_types/',
              icon: <SansSVG />,
              name: 'Виды животных',
            },
            {
              url: '/genders/',
              icon: <UserFemaleSVG />,
              name: 'Список полов',
            },
            {
              url: '/wool_types/',
              icon: <TagSVG />,
              name: 'Типы шерсти',
            },
            {
              url: '/tail_types/',
              icon: <TagSVG />,
              name: 'Типы хвостов',
            },
            {
              url: '/death_causes/',
              icon: <AedSVG />,
              name: 'Причины смерти',
            },
            {
              url: '/elimination_causes/',
              icon: <ClearSVG />,
              name: 'Причины выбытия из приюта',
            },
            {
              url: '/euthanasia_causes/',
              icon: <SubtractSVG />,
              name: 'Причины эвтаназии',
            },
          ]}
        />
        <AdminContent>{children}</AdminContent>
      </div>
    </div>
  );
};
