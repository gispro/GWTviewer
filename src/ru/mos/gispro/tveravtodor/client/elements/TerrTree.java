package ru.mos.gispro.tveravtodor.client.elements;

import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import ru.mos.gispro.tveravtodor.client.json.JSONTerr;
import ru.mos.gispro.tveravtodor.client.json.JSONTerrs;

public class TerrTree extends Tree {

	public void createTerrTree(JSONTerrs terrs) {
		TreeNode terrRoot = new TreeNode("root");
		TreeNode[] tn = new TreeNode[terrs.terrs().length()];
		for (int i = 0; i < terrs.terrs().length(); i++) {
			JSONTerr terr = terrs.terrs().get(i).cast();
			TreeNode t = new TreeNode(terr.name());
			if (terr.subterrs().length > 0) {
				TreeNode[] st = new TreeNode[terr.subterrs().length];
				for (int j = 0; j < terr.subterrs().length; j++) {
					TreeNode s = new TreeNode(terr.subterr(j));
					st[j] = s;
				}
				t.setChildren(st);
			}
			tn[i] = t;
		}
		this.setRoot(terrRoot);
		terrRoot.setChildren(tn);
	}
}
