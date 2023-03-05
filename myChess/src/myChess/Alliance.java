package myChess;

public enum Alliance {WHITE
	
 {
		@Override
		public int getDirection() {
			// TODO Auto-generated method stub
			return -1;
		}

		@Override
		public boolean isBlack() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isWhite() {
			// TODO Auto-generated method stub
			return true;
		}
	},	
BLACK

	
 {
		@Override
	public	int getDirection() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public boolean isBlack() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isWhite() {
			// TODO Auto-generated method stub
			return false;
		}
	};	
	
	public abstract int getDirection();
	
	public abstract boolean isBlack();
	public abstract boolean isWhite();
}
