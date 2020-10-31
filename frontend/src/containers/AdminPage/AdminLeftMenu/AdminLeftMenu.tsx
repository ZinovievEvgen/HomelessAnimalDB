import classnames from 'classnames';
import React from 'react';

import withClientContext from '@containers/SSRContext/ClientContext';
import { AdminLeftMenuLink } from './AdminLeftMenuLink/AdminLeftMenuLink';

import TransactionSVG from '@assets/static/images/transaction.svg';

import ServerContext from '@containers/SSRContext/ServerContext';
import * as S from './AdminLeftMenu.css';
import * as T from './AdminLeftMenu.types';

const AdminLeftMenu: React.FunctionComponent<T.IAdminLeftMenuContext> = ({
  className,
  links,
  pathname,
  entry = ServerContext.entry,
}) => {
  const [isOpen, setOpen] = React.useState<boolean>(true);

  const toggleMenu = (): void => {
    setOpen(!isOpen);
  };

  const wrapClass = classnames(
    S.wrap,
    {
      [S.closed]: !isOpen,
    },
    className
  );

  return (
    <div className={wrapClass}>
      <div className={S.top}>
        {links.map((link: T.ILink, index: number) => {
          const curPathname: string = `/${entry}/${link.url}`.replace(
            '//',
            '/'
          );
          const isActive: boolean = pathname === curPathname;

          return (
            <AdminLeftMenuLink
              key={index}
              shortLink={!isOpen}
              url={link.url}
              name={link.name}
              icon={link.icon}
              onClick={link.onClick}
              isActive={isActive}
            />
          );
        })}
      </div>
      <div className={S.bottom}>
        <AdminLeftMenuLink
          shortLink={!isOpen}
          name="Свернуть"
          icon={<TransactionSVG />}
          onClick={toggleMenu}
        />
      </div>
    </div>
  );
};

export const AdminLeftMenuWithContext = withClientContext<
  T.IAdminLeftMenuProps
>(AdminLeftMenu);
