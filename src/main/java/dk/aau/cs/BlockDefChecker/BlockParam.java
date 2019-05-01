package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;

import java.util.Objects;

public abstract class BlockParam {
	ExplicitGCode gCode;

	public BlockParam(String option, BlockDef blockDef) {
		this.gCode = generateGCode(option, blockDef);
	}

	public ExplicitGCode getGcode(){
		return gCode;
	}

	protected abstract ExplicitGCode generateGCode(String option, BlockDef blockDef);

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BlockParam that = (BlockParam) o;
		return Objects.equals(gCode, that.gCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gCode);
	}
}
