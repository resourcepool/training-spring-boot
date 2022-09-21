//user.model.ts
export class User {
  id: bigint | null;
  firstName: string;
  lastName: string;
  age: number;

  constructor(id: bigint | null, firstName: string, lastName: string, age: number) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
}
