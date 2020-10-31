import classnames from 'classnames';
import React from 'react';

import { AdminLeftMenuLink } from './AdminLeftMenuLink/AdminLeftMenuLink';

import TransactionSVG from '@assets/static/images/transaction.svg';

import * as S from './AdminLeftMenu.css';
import * as T from './AdminLeftMenu.types';

export const AdminLeftMenu: React.FunctionComponent<T.IAdminLeftMenuProps> = ({
  className,
  links,
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
        {links.map((link: T.ILink, index: number) => (
          <AdminLeftMenuLink
            key={index}
            shortLink={!isOpen}
            url={link.url}
            name={link.name}
            icon={link.icon}
            onClick={link.onClick}
          />
        ))}
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
