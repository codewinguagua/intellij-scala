package org.jetbrains.plugins.scala.lang.psi.stubs.elements.wrappers;

import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.scala.ScalaFileType;

import java.io.IOException;

/**
 * @author ilyas
 */
public abstract class IStubElementTypeWrapper<StubT extends StubElement, PsiT extends PsiElement> extends IStubElementType<StubT, PsiT> {

  public IStubElementTypeWrapper(@NotNull String debugName) {
    super(debugName, ScalaFileType.SCALA_LANGUAGE);
  }

  //Dirty delegate hack to avoid problems with inheritance in Scala which doesn't allow rawtyped parameters
  public StubT createStub(PsiT psi, StubElement parentStub) {
    return createStubImpl(psi, parentStub);
  }

  protected abstract StubT createStubImpl(PsiT psi, Object parentStub);

  //Dirty delegate hack to avoid problems with inheritance in Scala which doesn't allow rawtyped parameters
  public StubT deserialize(StubInputStream dataStream, StubElement parentStub) throws IOException {
    return deserializeImpl(dataStream, parentStub);
  }

  protected abstract StubT deserializeImpl(StubInputStream dataStream, Object parentStub);

}
