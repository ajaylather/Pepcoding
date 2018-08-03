package apr30;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;
	}
	
	private LinkedList<HMNode>[] buckets;
	private int size;
	
	public HashMap(){
		buckets = new LinkedList[4];
		size = 0;
		
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new LinkedList<>();
		}
	}

	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void put(K key, V value){
		int bi = hashfn(key);
		int foundAt = findWithinBucket(buckets[bi], key);
		
		if(foundAt == -1){
			HMNode n2add = new HMNode();
			n2add.key = key;
			n2add.value = value;
			buckets[bi].addLast(n2add);
			this.size++;
		} else {
			HMNode n2update = buckets[bi].getAt(foundAt);
			n2update.value = value;
		}
		
		double lambda = (this.size * 1.0) / this.buckets.length;
		
		if(lambda > 2.0){
			rehash();
		}
	}

	public boolean containsKey(K key){
		int bi = hashfn(key);
		int foundAt = findWithinBucket(buckets[bi], key);
		
		if(foundAt == -1){
			return false;
		} else {
			return true;
		}
	}
	
	public V get(K key){
		int bi = hashfn(key);
		int foundAt = findWithinBucket(buckets[bi], key);
		
		if(foundAt == -1){
			return null;
		} else {
			return buckets[bi].getAt(foundAt).value;
		}
	}
	
	public V remove(K key){
		int bi = hashfn(key);
		int foundAt = findWithinBucket(buckets[bi], key);
		
		if(foundAt == -1){
			return null;
		} else {
			this.size--;
			return buckets[bi].removeAt(foundAt).value;
		}
	}
	
	private int hashfn(K key) {
		int hc = key.hashCode();
		
		hc = Math.abs(hc) % buckets.length;
		
		return hc;
	}
	
	private int findWithinBucket(LinkedList<HMNode> list, K key) {
		for(int i = 0; i < list.size(); i++){
			HMNode node = list.getAt(i);
			if(node.key.equals(key)){
				return i;
			}
		}
		
		return -1;
	}

	public ArrayList<K> keyset(){
		ArrayList<K> keys = new ArrayList<>();
		
		for(int bi = 0; bi < buckets.length; bi++){
			for(int di = 0; di < buckets[bi].size(); di++){
				keys.add(buckets[bi].getAt(di).key);
			}
		}
		
		return keys;
	}
	
	public void display(){
		System.out.println("------------------------------------");
		
		for(int bi = 0; bi < buckets.length; bi++){
			System.out.print("B" + bi + " -> ");
			for(int di = 0; di < buckets[bi].size(); di++){
				HMNode node = buckets[bi].getAt(di);
				System.out.print(node.key + "@" + node.value + " ");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------");
	}
	
	private void rehash(){
		// save
		LinkedList<HMNode>[] oba = this.buckets;
		
		// reinit
		this.buckets = new LinkedList[2 * oba.length];
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new LinkedList<>();
		}
		size = 0;
		
		// refill it
		for(int bi = 0; bi < oba.length; bi++){
			for(int di = 0; di < oba[bi].size(); di++){
				HMNode node = oba[bi].getAt(di);
				put(node.key, node.value);
			}
		}
		
	}
}
