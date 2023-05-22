package cs3500.pa01.controller;

import cs3500.pa01.sessionwriter.InSessionWriter;
import cs3500.pa01.sessionwriter.PostSessionWriter;
import cs3500.pa01.sessionwriter.SessionSetupWriter;

/**
 * Class responsible for executing a study session
 */
public class StudySessionController implements Controller {

  /**
   * Handles running a study session
   */
  public void run() {
    SessionSetupWriter sessionSetup = new SessionSetupWriter();
    sessionSetup.write();

    InSessionWriter inSessionWriter = new InSessionWriter(sessionSetup.qc1, sessionSetup.qc2);
    inSessionWriter.write();

    PostSessionWriter postSessionWriter = new PostSessionWriter(sessionSetup.qc1, sessionSetup.qc2,
        sessionSetup.filePath, inSessionWriter.inputReader);
    postSessionWriter.write();
  }
}
