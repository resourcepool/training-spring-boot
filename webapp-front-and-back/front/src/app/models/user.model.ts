import { defaultsDeep } from 'lodash';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  age: number;

  constructor(user?: Partial<User>) {
    defaultsDeep(this, user);
  }
}
