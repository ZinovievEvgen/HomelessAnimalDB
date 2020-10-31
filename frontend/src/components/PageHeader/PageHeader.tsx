import Link from '@components/Link';
import classnames from 'classnames';
import React from 'react';

import * as S from './PageHeader.css';
import * as T from './PageHeader.types';

export const PageHeader: React.FunctionComponent<T.IPageHeaderProps> = ({
  hrefs,
  title,
  className,
}) => {
  const wrapClass = classnames(S.wrap, className);

  return (
    <div className={wrapClass}>
      {title &&
        (!!title.url ? (
          <Link className={S.icon} to={title.url}>
            {title.icon}
            <span className={S.iconText}>{title.text}</span>
          </Link>
        ) : (
          <span className={S.icon}>
            {title.icon}
            <span className={S.iconText}>{title.text}</span>
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
