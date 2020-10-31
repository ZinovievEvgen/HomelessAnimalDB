export interface IAdminLeftMenuProps {
  className?: string;
  links: ILink[];
}

export interface ILink {
  name: string;
  icon: React.ReactNode;
  onClick?: () => void;
  url?: string;
}
