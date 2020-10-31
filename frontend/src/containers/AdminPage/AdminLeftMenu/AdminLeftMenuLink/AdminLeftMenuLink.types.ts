export interface IAdminLeftMenuLinkProps {
  name: string;
  icon?: React.ReactNode;
  url?: string;
  onClick?: () => void;
  shortLink?: boolean;
}

export interface ILinkProp {
  onClick?: IAdminLeftMenuLinkProps['onClick'];
  name?: IAdminLeftMenuLinkProps['name'];
  icon?: IAdminLeftMenuLinkProps['icon'];
  shortLink?: IAdminLeftMenuLinkProps['shortLink'];
}
