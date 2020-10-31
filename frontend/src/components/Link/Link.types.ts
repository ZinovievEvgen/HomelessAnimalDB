import { LinkProps } from 'react-router-dom';

export interface ILinkProps extends LinkProps {
  children: React.ReactNode;
}

export interface ILinkContext extends ILinkProps {
  entry: string;
}
