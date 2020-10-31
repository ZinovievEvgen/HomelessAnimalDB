export interface IAdminLeftMenuProps {
  className?: string;
  links: ILink[];
  pathname: string;
}

export interface IAdminLeftMenuContext extends IAdminLeftMenuProps {
  entry: string;
}

export interface ILink {
  name: string;
  icon: React.ReactNode;
  onClick?: () => void;
  url?: string;
}
