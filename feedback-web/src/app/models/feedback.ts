export class Feedback {

  constructor(
    public productId: string,
    public description: string,
    public userId: string,
    public starCount: number
  ) {}
}
