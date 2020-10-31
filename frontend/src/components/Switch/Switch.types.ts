import { RouteProps } from 'react-router-dom';

export interface ISwitchProps {
  routes: IRoute[];
}

export interface ISwitchContext extends ISwitchProps {
  entry: string;
}

export interface IRoute extends RouteProps {
  path?: string;
  Component: React.FunctionComponent<any>;
}
