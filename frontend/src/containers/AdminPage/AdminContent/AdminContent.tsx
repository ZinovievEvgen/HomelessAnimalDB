import React from 'react';

import * as T from './AdminContent.types';

export const AdminContent: React.FunctionComponent<T.IAdminContentProps> = ({
  children,
}) => {
  return <>{children}</>;
};
