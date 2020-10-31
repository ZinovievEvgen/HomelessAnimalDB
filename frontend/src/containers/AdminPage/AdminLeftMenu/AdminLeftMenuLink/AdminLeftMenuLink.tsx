import Link from '@components/Link';
import classnames from 'classnames';
import React from 'react';

import * as S from './AdminLeftMenuLink.css';
import * as T from './AdminLeftMenuLink.types';

const LinkComponent: React.FunctionComponent<T.ILinkProp> = ({
  onClick,
  icon,
  name,
  shortLink,
  isActive,
}) => {
  const linkClass = classnames(S.link, {
    [S.short]: shortLink,
  });

  const decoratorClass = classnames(S.decorator, {
    [S.activeDecorator]: isActive,
  });

  return (
    <div onClick={onClick} className={linkClass}>
      <div className={decoratorClass} />
      <span className={S.icon}>{icon}</span>
      {!shortLink && <span className={S.text}>{name}</span>}
    </div>
  );
};

export const AdminLeftMenuLink: React.FunctionComponent<T.IAdminLeftMenuLinkProps> = ({
  name,
  icon,
  url,
  onClick,
  shortLink,
  isActive,
}) =>
  url ? (
    <Link to={url}>
      <LinkComponent
        icon={icon}
        name={name}
        shortLink={shortLink}
        isActive={isActive}
      />
    </Link>
  ) : (
    <LinkComponent
      icon={icon}
      name={name}
      onClick={onClick}
      shortLink={shortLink}
      isActive={isActive}
    />
  );
