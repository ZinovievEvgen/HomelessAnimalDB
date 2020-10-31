export interface IPageHeaderProps {
  hrefs: IHref[];
  icon?: IHeaderIcon;
  className?: string;
}

export interface IHref {
  name: string;
  url?: string;
  onClick?: () => void;
}

export interface IHeaderIcon {
  Component: React.ReactNode;
  text?: string;
  url?: string;
}
