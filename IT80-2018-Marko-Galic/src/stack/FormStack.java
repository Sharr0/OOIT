package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Circle;


public class FormStack extends JFrame {

	DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormStack frame = new FormStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormStack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblstack = new JLabel("Stack");
		pnlNorth.add(lblstack);

		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		pnlCentar.add(scrollPane);

		JList<Circle> lstCircle = new JList();
		scrollPane.setViewportView(lstCircle);
		lstCircle.setModel(dlm);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true);
				if (dlgStack.confirmation) {
					try {
						int x = Integer.parseInt(dlgStack.getTxtX().getText());
						int y = Integer.parseInt(dlgStack.getTxtY().getText());
						int radius = Integer.parseInt(dlgStack.getTxtRadius().getText());

						Circle circle = new Circle(radius, new Point(x,y));

						dlm.add(0, circle);

					} catch (Exception NumberFormatException) {

						JOptionPane.showMessageDialog(null, "Please, insert values!");

					}

				}

			}
		});
		pnlSouth.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty!");
				} else {
					DlgStack dlg = new DlgStack();
					Point p = dlm.getElementAt(0).getCenter();
					int radius = dlm.getElementAt(0).getRadius();

					dlg.getTxtX().setText("" + Integer.toString(p.getX()));
					dlg.getTxtY().setText("" + Integer.toString(p.getY()));
					dlg.getTxtRadius().setText("" + Integer.toString(radius));

					dlg.setVisible(true);

					if (dlg.confirmation) {
						dlm.remove(0);
					}

				}
			}
		});
		pnlSouth.add(btnDelete);
	}

}
