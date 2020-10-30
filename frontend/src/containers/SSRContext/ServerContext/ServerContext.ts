import { IServerContext } from '@types';
import { PRERENDERED_KEY } from '../SSRContext.contants';

export const ServerContext: IServerContext = {
  entry: '',
  context: {},
};

export const exportContext = (): string => `
  <script>
    window.${PRERENDERED_KEY}='${JSON.stringify(ServerContext).replace(
  /</g,
  '\\u003c'
)}'
  </script>
`;
