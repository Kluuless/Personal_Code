import javax.swing.*;
import java.awt.*;
import java.io.File;

class gui {
	private static void makeCells(Container pane) {
		
	}
	
	private static int[] get(JButton cells[][], JButton cell) {
		int[] rc = {-1,-1};
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (cells[i][j].equals(cell)) {
					rc[0] = i;
					rc[1] = j;
					return rc;
				}
			}
		}
		return rc;
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("GUI Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		int[] gridSize = {100, 100};
		int cellSize = 8;
		frame.setSize(gridSize[0] * cellSize, (gridSize[1] + cellSize) * cellSize);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//File imageCheck = new File("filled_tile.jpg");
		//if (imageCheck.exists()) { System.out.println("filled_tile found!"); }
		//else { System.out.println("filled_tile not found!"); }
		
		//Icon filled_icon = new ImageIcon("filled_tile.jpg");
		//Icon empty = new ImageIcon("empty_tile.png");
		
		JButton[][] cells = new JButton[gridSize[0]][gridSize[1]];
		boolean[][] clicked = new boolean[gridSize[0]][gridSize[1]];
		for (int i = 0; i < gridSize[0]; i++) {
			for (int j = 0; j < gridSize[1]; j++) {
				clicked[i][j] = false;
				c.gridx = i;
				c.gridy = j;
				cells[i][j] = new JButton();
				cells[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
				cells[i][j].setPreferredSize(new Dimension(cellSize, cellSize));
				cells[i][j].setBackground(Color.WHITE);
				cells[i][j].setMargin(new Insets(0, 0, 0, 0));
				
				ActionListener listener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Object source = e.getSource();
						if (source instanceof JButton) {
							source = (JButton)source;
							idxs = gui.get(cells,source);
							if (idxs[0] >= 0 && idxs[1] >= 0) {
								if (clicked[idxs[0]][idxs[1]]) {
									clicked[idxs[0]][idxs[1]] = false;
									cells[idxs[0]][idxs[1]].setBackground(Color.LIGHT_GRAY);
								} else {
									clicked[idxs[0]][idxs[1]] = true;
									cells[idxs[0]][idxs[1]].setBackground(Color.BLACK);
								}
							}
						}
					}
				};
				
				//cells[i][j].updateUI();
				frame.getContentPane().add(cells[i][j], c);
			}
		}
		
		JButton run = new JButton("Run");
		//run.setIcon(filled_icon);
		c.gridx = 0;
		c.gridy = gridSize[1];
		c.gridwidth = gridSize[0] + 1;
		run.setBackground(Color.WHITE);
		//c.gridheight = gridSize[1] / 10;
		frame.getContentPane().add(run, c);
		
		frame.pack();
		frame.setVisible(true);
	}
}