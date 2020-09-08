import { User } from './user';

export class Reimbursement {
    id: number;
    amount: number;
    submit: Date;
    author: User;
    resolve: Date;
    resolver: User;
    status: string;
    type: string;
}
