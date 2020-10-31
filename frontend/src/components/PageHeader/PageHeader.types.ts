export interface IPageHeaderProps {
  hrefs: IHref[];
  title?: IHeaderTitle;
  className?: string;
}

export interface IHref {
  name: string;
  url?: string;
  onClick?: () => void;
}

export interface IHeaderTitle {
  icon?: React.ReactNode;
  text?: string;
  url?: string;
}
