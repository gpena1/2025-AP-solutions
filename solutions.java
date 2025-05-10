// Q1 Part A
public int walkDogs(int hour){
	int available = numAvailableDogs(hour);
	int dogs_to_walk = Math.min(available, maxDogs);
	updateDogs(hour, dogs_to_walk);
	return dogs_to_walk;
}

// Q1 Part B
public int dogWalkShift(int startHour, int endHour){
	int paid = 0;
	for(int hour = startHour; hour <= endHour; ++hour){
		int walked = walkDogs(hour);
		paid += 5 * walked;
		if(walked == maxDogs || (9 <= hour && hour <= 17))
			paid += 3;
	}
	return paid;
}

// Q2
class SignedText{
    private String first_name, last_name;
    public SignedText(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public String getSignature(){
        if(first_name.length() == 0) return last_name;
        return first_name.substring(0,1) + "-" + last_name;
    }
    public String addSignature(String str){
        String signature = getSignature();
        if(str.indexOf(signature) == -1)
            return str + signature;
        if(str.length() >= signature.length() && str.substring(str.length()-signature.length()).equals(signature))
            return str;
        if(str.length() >= signature.length() && str.substring(0, signature.length()).equals(signature))
            return str.substring(signature.length()) + signature;
        return "";
    }
}

// Q3 Part A
public Round(String[] names){
	competitorList = new ArrayList<>();
	for(int i=0;i<names.length;++i){
		competitorList.add(new Competitor(names[i], i+1));
	}
}

// Q3 Part B
public ArrayList<Match> buildMatches(){
	int size = competitorList.size();
	ArrayList<Match> matches = new ArrayList<>();
	if(size == 1) return matches;
	if(size % 2 == 0){
		for(int i=0;i<size/2;++i){
			matches.add(new Match(competitorList.get(i), competitorList.get(size-i-1)));
		}
	} else {
		for(int i=1;i<=size/2;++i){
			matches.add(new Match(competitorList.get(i), competitorList.get(size-i)));
		}
	}
	return matches;
}

// Q4 Part A
public SumOrSameGame(int numRows, int numCols){
	puzzle = new int[numRows][numCols];
	for(int row = 0; row < numRows; ++row){
		for(int col = 0; col < numCols; ++col){
			puzzle[row][col] = (int) (Math.random() * 9 + 1);
		}
	}
}

// Q4 Part B
public boolean clearPair(int row, int col){
	for(int r = 0; r < puzzle.length; ++r){
		for(int c = 0; c < puzzle[r].length; ++c){
			if(r == row && c == col) continue;
			if(puzzle[r][c] == puzzle[row][col] || puzzle[r][c] + puzzle[row][col] == 10) {
				puzzle[r][c] = puzzle[row][col] = 0;
				return true;
			}
		}
	}
	return false;
}
