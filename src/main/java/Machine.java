import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by elena on 08.10.15.
 */
public class Machine {
	private int alphabet;
	private int numOfStates;
	private int firstState;
	private int numOfLastStates;
	private int[] lastState = new int[numOfLastStates];
	private Map<Integer,Map<String, List<Integer>>> machine = new HashMap<Integer, Map<String, List<Integer>>>();
	private Map<Integer,Integer> stateEquality = new HashMap<Integer,Integer>();
	int newState;

	public Machine(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new FileReader(filename));
		alphabet = file.nextInt();
		numOfStates = file.nextInt();
		firstState = file.nextInt();
		numOfLastStates = file.nextInt();
		for (int i = 0; i < numOfLastStates; i++) {
			lastState[i] = file.nextInt();
		}
		while (file.hasNext()) {
			int stateFrom = file.nextInt();
			String symbol = file.next();
			int stateTo = file.nextInt();
			machine = addToMachine(stateFrom, symbol, stateTo, machine);
		}
	}

	private Map<Integer,Map<String, List<Integer>>> addToMachine(int stateFrom, String symbol, int stateTo, Map<Integer,Map<String, List<Integer>>> machine) {
		Map<String, List<Integer>> sb = machine.getOrDefault(stateFrom, new HashMap<String, List<Integer>>());
		List<Integer> st = sb.getOrDefault(symbol, new ArrayList<Integer>());
		st.add(stateTo);
		sb.put(symbol, st);
		machine.put(stateFrom, sb);

		return machine;
	}

	private Machine NFAtoDFA(int state, String symbol) {
		Map<Integer,Map<String, List<Integer>>> newMachine = new HashMap<Integer, Map<String, List<Integer>>>();
		newMachine = addToMachine(state, symbol, newState, newMachine);
		++newState;
		Map<String, List<Integer>> sb = this.machine.get(state);
		if (sb != null) {
			List<Integer> st = sb.get(symbol);
			for (Integer curSt : st) {
				if (stateEquality.get(curSt) == null) {

					for (String curSb : this.machine.get(curSt).keySet()) {
						NFAtoDFA(curSt, curSb);
					}
				}
			}
		}

		return this;
	}

	private Machine Change(){
		Map<Integer,Map<String, List<Integer>>> newMachine = new HashMap<Integer, Map<String, List<Integer>>>();
		newState = 1;
		return
	}


}
