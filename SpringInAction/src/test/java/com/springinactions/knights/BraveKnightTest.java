package com.springinactions.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class BraveKnightTest {
	@Test
	public void knightShouldEmbarkOnQuest(){
		//create mock Quest
		Quest mockQuest = mock(Quest.class);
		
		//inject mock Quest
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		
		verify(mockQuest, times(1)).embark();
	}
}
