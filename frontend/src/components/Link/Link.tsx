import React from 'react';
import { Link } from 'react-router-dom';

import withClientContext from '@containers/SSRContext/ClientContext';
import ServerContext from '@containers/SSRContext/ServerContext';

import * as T from './Link.types';

const MyLink: React.FunctionComponent<T.ILinkContext> = ({
  children,
  to,
  entry = ServerContext.entry,
  ...otherProps
}) => {
  const newPath: string = to ? `/${entry}/${to}`.replace('//', '/') : null;

  return (
    <Link to={newPath} {...otherProps}>
      {children}
    </Link>
  );
};

export const LinkWithContext = withClientContext<T.ILinkProps>(MyLink);
