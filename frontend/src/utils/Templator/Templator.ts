import * as T from './Templator.types';

export const Templator = (
  template: string,
  props: T.ITemplatorProps
): string => {
  let fullfieldTemplate: string = template;

  Object.entries(props).forEach(([key, value]: string[]) => {
    fullfieldTemplate = fullfieldTemplate.replace(`{% ${key} %}`, value);
  });

  fullfieldTemplate = fullfieldTemplate.replace(/{%.*%}/, '');
  fullfieldTemplate = fullfieldTemplate.replace(/\s{2,}|\t/g, '');

  return fullfieldTemplate;
};
