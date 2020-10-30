import React from 'react';

import * as S from './AdminPage.css';
import * as T from './AdminPage.types';

export const AdminPage: React.FunctionComponent<T.IAdminPageProps> = ({
  children,
}) => {
  return <div className={S.wrap}>{children}</div>;
};
