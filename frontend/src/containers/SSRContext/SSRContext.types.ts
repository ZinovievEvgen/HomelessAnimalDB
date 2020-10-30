import { ISrtingDict } from '@types';
import { StaticRouterContext } from 'react-router';

export interface IClientContext extends ISrtingDict<any> {
  entry: string;
  context?: StaticRouterContext;
}
