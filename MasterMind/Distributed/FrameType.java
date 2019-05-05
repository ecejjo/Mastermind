package MasterMind.Distributed;

public enum FrameType { 
	GET_GAME, 
	SET_GAME,
	EXIT;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
