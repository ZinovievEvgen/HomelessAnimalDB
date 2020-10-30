import { StaticRouterContext } from 'react-router';

export interface IServerContainerProps {
  children: React.ReactNode;
  location: string;
  entry: string;
  context?: StaticRouterContext;
}
