package itemLoot;

public class Item {
	public enum ItemUsage {
		ONCE, CONT, PASSIVE
	};

	public enum ItemType {
		ASSIGNMENT, EXAMS, DUEDATE, NUMATTEMPTS
	};

	private ItemUsage usage;
	private ItemType type;
	private String name;
	private float cost, rarity, amount;

	public Item(String name) {
		this.name = name;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setRarity(float rarity) {
		this.rarity = rarity;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public void setUsage(ItemUsage usage) {
		this.usage = usage;
	}

	public ItemType getType() {
		return type;
	}

	public ItemUsage getUsage() {
		return usage;
	}

	public String getName() {
		return name;
	}

	public float getCost() {
		return cost;
	}

	public float getRarity() {
		return rarity;
	}

	public float getAmount() {
		return amount;
	}
}