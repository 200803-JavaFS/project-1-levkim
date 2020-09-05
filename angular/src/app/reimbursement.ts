import { User } from './user';

export class Reimbursement {
    constructor(amount: number, submit: Date, resolve: Date, desc: String, receipt: File, author: User, resolver: User) {
        amount = this.amount;
        submit = this.submit;
        resolve = this.resolve;
        desc = this.desc;
        receipt = this.receipt;
        author = this.author;
        resolver = this.resolver;
    }

    amount: number;
    submit: Date;
    resolve: Date;
    desc: String;
    receipt: File;
    author: User;
    resolver: User;
}
