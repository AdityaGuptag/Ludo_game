package AnimationPkg;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class DiceAnimation {

	public DiceAnimation() {

	}

	public static void rollDice(int diceNum,
			Group allImages,
			ImageView one, 
			ImageView two, 
			ImageView three, 
			ImageView four, 
			ImageView five, 
			ImageView six) {
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(one);
					}

				}),
				new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(two);
					}

				}),
				new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(three);
					}

				}),
				new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(four);
					}

				}),
				new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(five);
					}

				}),
				new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						allImages.getChildren().setAll(six);
					}

				}),
				new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						switch (diceNum) {
							case 1 : allImages.getChildren().setAll(two);
								break;
							case 2 : allImages.getChildren().setAll(five);
								break;
							case 3 : allImages.getChildren().setAll(four);
								break;
							case 4 : allImages.getChildren().setAll(six);
								break;
							case 5 : allImages.getChildren().setAll(three);
								break;
							case 6 : allImages.getChildren().setAll(one);
								break;
						}
					}

				}));

		timeline.play();
	}


}
