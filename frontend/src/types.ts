import { IClientContext } from '@containers/SSRContext/SSRContext.types';
import { StaticRouterContext } from 'react-router';

export interface ISrtingDict<R> {
  [key: string]: R;
}

export interface INumberDicr<R> {
  [key: number]: R;
}

export interface ISSRProps {
  location: string;
  entry: string;
  context?: StaticRouterContext;
}

export interface ITemplateProps extends ISrtingDict<any> {
  template: string;
  CLIENT_SCRIPT_SRC?: string;
}

export type ISSRFunc = (props: ISSRProps) => ITemplateProps;

export type IServerContext = IClientContext;
