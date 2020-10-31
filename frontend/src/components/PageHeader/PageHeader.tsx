import Link from '@components/Link';
import classnames from 'classnames';
import React from 'react';

import * as S from './PageHeader.css';
import * as T from './PageHeader.types';

export const PageHeader: React.FunctionComponent<T.IPageHeaderProps> = ({
  hrefs,
  icon,
  className,
}) => {
  const wrapClass = classnames(S.wrap, className);

  return (
    <div className={wrapClass}>
      {icon &&
        (!!icon.url ? (
          <Link className={S.icon} to={icon.url}>
            {icon.Component}
            <span className={S.iconText}>{icon.text}</span>
          </Link>
        ) : (
          <span className={S.icon}>
            {icon.Component}
            <span className={S.iconText}>{icon.text}</span>
          </span>
        ))}
      <div className={S.links}>
        {hrefs.map((href: T.IHref, index: number) =>
          href.url ? (
            <Link className={S.link} key={index} to={href.url}>
              {href.name}
            </Link>
          ) : (
            <span className={S.link} onClick={href.onClick} key={index}>
              {href.name}
            </span>
          )
        )}
      </div>
    </div>
  );
};
